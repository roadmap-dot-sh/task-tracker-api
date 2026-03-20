# Task Tracker

project url: <a href="https://roadmap.sh/projects/task-tracker">https://roadmap.sh/projects/task-tracker</a>

## Run application

Open terminal and run these commands

1. Clone repo

```
git clone https://github.com/roadmap-dot-sh/task-tracker-api.git
cd task-tracker-api 
```

2. Start app

- Build .jar file

```
mvn clean package
```

Output: `target/task-tracker-api-0.0.1-SNAPSHOT.jar`

3. Test

- Add Task: Pass parameter `description`
  ```
  java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar add <description>
  ```

- Update Task: Pass 2 parameters `id` and `description`
  ```
  java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar update <id> <description>
  ```

- Delete Task: Pass parameter `id`
  ```
  java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar delete <id>
  ```

- Mark task in progress: Pass parameter `id`
  ```
  java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar mark-in-progress <id>
  ```

- Mark task completed: Pass parameter `id`
  ```
  java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar mark-completed <id>
  ```

- List all tasks
  ```
  java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar list
  ```