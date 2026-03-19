# Task Tracker

project url: <a href="https://roadmap.sh/projects/task-tracker">https://roadmap.sh/projects/task-tracker</a>

## Run application

1. Clone repo

```
git clone https://github.com/roadmap-dot-sh/task-tracker-api.git
cd task-tracker-api 
```

2. Start app

   Open terminal and run these commands

- Build .jar file:

```
mvn clean package
```

- Output: `target/task-tracker-api-0.0.1-SNAPSHOT.jar`
    - Test:
        - add
          ```
          java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar add <description>
          ```

        - update
          ```
          java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar update <id> <description>
          ```

        - delele
          ```
          java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar delete <id>
          ```

        - mark in progress
          ```
          java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar mark-in-progress <id>
          ```

        - mark completed
          ```
          java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar mark-completed <id>
          ```

        - list
          ```
          java -jar target/task-tracker-api-0.0.1-SNAPSHOT.jar list
          ```