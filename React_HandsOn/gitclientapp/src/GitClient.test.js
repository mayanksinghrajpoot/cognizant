import axios from 'axios';
import { GitClient } from './GitClient';

jest.mock('axios');

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    const mockData = [
      { name: 'repo1' },
      { name: 'repo2' }
    ];
    axios.get.mockResolvedValue({ data: mockData });

    const repos = await GitClient.getRepositories('techiesyed');
    expect(repos).toEqual(['repo1', 'repo2']);
    expect(axios.get).toHaveBeenCalledWith('https://api.github.com/users/techiesyed/repos');
  });
});
