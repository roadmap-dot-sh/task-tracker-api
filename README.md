# Task Tracker

Build a CLI app to track your tasks and manage your to-do list.

Project URL: <a href="https://roadmap.sh/projects/task-tracker">https://roadmap.sh/projects/task-tracker</a>

## Requirements

The application should run from the command line, accept user actions and inputs as arguments, and store the tasks in a
JSON file. The user should be able to:

- Add, Update, and Delete tasks
- Mark a task as in progress or done
- List all tasks
- List all tasks that are done
- List all tasks that are not done
- List all tasks that are in progress

Here are some constraints to guide the implementation:

- You can use any programming language to build this project.
- Use positional arguments in command line to accept user inputs.
- Use a JSON file to store the tasks in the current directory.
- The JSON file should be created if it does not exist.
- Use the native file system module of your programming language to interact with the JSON file.
- Do not use any external libraries or frameworks to build this project.
- Ensure to handle errors and edge cases gracefully.

#### Example

The list of commands and their usage is given below:

```shell
# Adding a new task
task-cli add "Buy groceries"
# Output: Task added successfully (ID: 1)

# Updating and deleting tasks
task-cli update 1 "Buy groceries and cook dinner"
task-cli delete 1

# Marking a task as in progress or done
task-cli mark-in-progress 1
task-cli mark-done 1

# Listing all tasks
task-cli list

# Listing tasks by status
task-cli list done
task-cli list todo
task-cli list in-progress
```

#### Task Properties

Each task should have the following properties:

- `id`: A unique identifier for the task
- `description`: A short description of the task
- `status`: The status of the task (`todo`, `in-progress`, `done`)
- `createdAt`: The date and time when the task was created
- `updatedAt`: The date and time when the task was last updated

Make sure to add these properties to the JSON file when adding a new task and update them when updating a task

## Run application

Open terminal and run these commands

##### 1. Clone repository and change to project directory

```shell
git clone https://github.com/roadmap-dot-sh/task-tracker-api.git
cd task-tracker-api 
```

##### 2. Build `.jar` file

```shell
mvn clean package
```

Output: `target/task-tracker-api-0.0.1-SNAPSHOT.jar`

##### 3. Run and test

- Add Task: Pass parameter `description`
  ```shell
  java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar add <description>
  ```

- Update Task: Pass 2 parameters `id` and `description`
  ```shell
  java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar update <id> <description>
  ```

- Delete Task: Pass parameter `id`
  ```shell
  java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar delete <id>
  ```

- Mark task in progress: Pass parameter `id`
  ```shell
  java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar mark-in-progress <id>
  ```

- Mark task completed: Pass parameter `id`
  ```shell
  java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar mark-completed <id>
  ```

- List all tasks
  ```shell
  java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar list
  ```