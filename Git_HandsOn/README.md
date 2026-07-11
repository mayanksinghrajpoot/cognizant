# Git Hands-On Labs (1-5)

This folder contains the files and documentation representing the Git exercises completed for the deepskilling module.

## Exercises Completed

### Git HOL 1: Configuration & Setup
- Configured user level variables:
  ```bash
  git config --global user.name "Your Name"
  git config --global user.email "your.email@example.com"
  ```
- Set default core editor (simulated config):
  ```bash
  git config --global core.editor "notepad++ -multiInst -nosession"
  ```
- Created `welcome.txt` file and tracked it with `git add welcome.txt` and `git commit`.

### Git HOL 2: Ignoring Files
- Created `.gitignore` file to ignore:
  - `.log` files (`*.log`)
  - `log/` directories
  - backup files (`*.bak`, `*.orig`)
- Staged and committed `.gitignore`.

### Git HOL 3: Branching & Merging
- Created a new branch named `GitNewBranch`:
  ```bash
  git branch GitNewBranch
  ```
- Switched to the new branch:
  ```bash
  git checkout GitNewBranch
  ```
- Added and committed mock files on the branch, merged them back to the trunk (`main`), and deleted the branch.

### Git HOL 4: Conflict Resolution
- Simulated merge conflicts by creating diverging content in `hello.xml` on `GitWork` branch and `main` branch.
- Attempted merge, observed conflicts, and resolved them by cleaning up conflicts and saving the resolved version in `hello.xml`.
- Committed the resolved merge.

### Git HOL 5: Syncing Remote
- Pulled latest modifications with `git pull`.
- Pushed all completed commits up to remote using `git push`.
