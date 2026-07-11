package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.repository.*;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.StockService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.AttemptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");
    }

    @Bean
    public CommandLineRunner demo(
            CountryService countryService,
            StockService stockService,
            EmployeeService employeeService,
            AttemptService attemptService,
            DepartmentRepository departmentRepository,
            SkillRepository skillRepository,
            EmployeeRepository employeeRepository,
            UserRepository userRepository,
            QuestionRepository questionRepository,
            OptionsRepository optionsRepository,
            AttemptRepository attemptRepository,
            AttemptQuestionRepository attemptQuestionRepository,
            AttemptOptionRepository attemptOptionRepository
    ) {
        return args -> {
            LOGGER.info("--- Seeding Database for orm-learn ---");

            // Seed Countries
            countryService.addCountry(new Country("IN", "India"));
            countryService.addCountry(new Country("US", "United States of America"));
            countryService.addCountry(new Country("ZA", "South Africa"));
            countryService.addCountry(new Country("LU", "Luxembourg"));
            countryService.addCountry(new Country("BV", "Bouvet Island"));

            // Seed Stocks
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            stockService.saveStock(new Stock("FB", df.parse("2019-09-03"), new BigDecimal("184.00"), new BigDecimal("182.39"), 9779400L));
            stockService.saveStock(new Stock("FB", df.parse("2019-09-04"), new BigDecimal("184.65"), new BigDecimal("187.14"), 11308000L));
            stockService.saveStock(new Stock("FB", df.parse("2019-01-31"), new BigDecimal("165.60"), new BigDecimal("166.69"), 77233600L));
            stockService.saveStock(new Stock("GOOGL", df.parse("2019-04-26"), new BigDecimal("1273.38"), new BigDecimal("1277.42"), 1361400L));

            // Seed Dept, Skills, Employee
            Department it = departmentRepository.save(new Department("IT"));
            Department hr = departmentRepository.save(new Department("HR"));

            Skill java = skillRepository.save(new Skill("Java"));
            Skill spring = skillRepository.save(new Skill("Spring Boot"));

            Employee emp1 = new Employee("John Permanent", 85000, 1, df.parse("1985-05-15"), it, List.of(java, spring));
            Employee emp2 = new Employee("Jane Temp", 45000, 0, df.parse("1990-07-20"), hr, List.of(java));
            employeeRepository.save(emp1);
            employeeRepository.save(emp2);

            // Seed Quiz tables
            User user = userRepository.save(new User("techiesyed"));
            Question q1 = questionRepository.save(new Question("What is the extension of the hyper text markup language file?"));
            Options op1 = optionsRepository.save(new Options(q1, ".xhtm", 0.0));
            Options op2 = optionsRepository.save(new Options(q1, ".ht", 0.0));
            Options op3 = optionsRepository.save(new Options(q1, ".html", 1.0));
            Options op4 = optionsRepository.save(new Options(q1, ".htmx", 0.0));

            Question q2 = questionRepository.save(new Question("What is the maximum level of heading tag can be used in a HTML page?"));
            Options op2_1 = optionsRepository.save(new Options(q2, "5", 0.0));
            Options op2_2 = optionsRepository.save(new Options(q2, "3", 0.0));
            Options op2_3 = optionsRepository.save(new Options(q2, "4", 0.0));
            Options op2_4 = optionsRepository.save(new Options(q2, "6", 1.0));

            Attempt attempt = attemptRepository.save(new Attempt(user, new Date()));
            
            AttemptQuestion aq1 = attemptQuestionRepository.save(new AttemptQuestion(attempt, q1));
            attemptOptionRepository.save(new AttemptOption(aq1, op3, true)); // Selected .html

            AttemptQuestion aq2 = attemptQuestionRepository.save(new AttemptQuestion(attempt, q2));
            attemptOptionRepository.save(new AttemptOption(aq2, op2_4, true)); // Selected 6

            LOGGER.info("--- Seeding Completed successfully ---");

            // Test Queries
            testCountryQueries(countryService);
            testStockQueries(stockService);
            testEmployeeQueries(employeeService, it.getId());
            testQuizQueries(attemptService, user.getId(), attempt.getId());
        };
    }

    private void testCountryQueries(CountryService countryService) {
        LOGGER.info("Executing testCountryQueries...");
        List<Country> search1 = countryService.searchCountriesByName("ou");
        LOGGER.info("Countries containing 'ou' in alphabetical order: {}", search1);

        List<Country> search2 = countryService.searchCountriesByAlphabet("L");
        LOGGER.info("Countries starting with 'L': {}", search2);
    }

    private void testStockQueries(StockService stockService) throws Exception {
        LOGGER.info("Executing testStockQueries...");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date start = df.parse("2019-09-01");
        Date end = df.parse("2019-09-30");
        List<Stock> fbSeptember = stockService.getStocksByCodeAndDateRange("FB", start, end);
        LOGGER.info("Facebook stocks in Sept 2019: {}", fbSeptember);

        List<Stock> googleHigh = stockService.getStocksAbovePrice("GOOGL", new BigDecimal("1250.00"));
        LOGGER.info("Google stocks > 1250: {}", googleHigh);

        List<Stock> top3Volume = stockService.getTop3HighestVolumeStocks();
        LOGGER.info("Top 3 highest volume transactions: {}", top3Volume);
    }

    private void testEmployeeQueries(EmployeeService employeeService, int deptId) {
        LOGGER.info("Executing testEmployeeQueries...");
        List<Employee> permEmps = employeeService.getAllPermanentEmployees();
        LOGGER.info("Permanent Employees: {}", permEmps);
        for (Employee e : permEmps) {
            LOGGER.info("Employee {} skills: {}", e.getName(), e.getSkillList());
        }

        double avgSal = employeeService.getAverageSalary(deptId);
        LOGGER.info("Average salary for Department ID {}: {}", deptId, avgSal);

        List<Employee> allNative = employeeService.getAllEmployeesNative();
        LOGGER.info("All Employees (Native Query): {}", allNative);
    }

    private void testQuizQueries(AttemptService attemptService, int userId, int attemptId) {
        LOGGER.info("Executing testQuizQueries...");
        Attempt attempt = attemptService.getAttempt(userId, attemptId);
        LOGGER.info("Attempt Detail by User {}:", attempt.getUser().getName());
        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
            LOGGER.info("Question: {}", aq.getQuestion().getText());
            for (AttemptOption ao : aq.getAttemptOptions()) {
                LOGGER.info("  Option: {} | Score: {} | Selected: {}", 
                        ao.getOption().getText(), ao.getOption().getScore(), ao.isSelected());
            }
        }
    }
}
