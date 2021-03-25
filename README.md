<h1 align="center">Docker compose - Task List</h1>

<div align="center">

[![Build Status](https://img.shields.io/badge/spring-2.4.4-brightgreen)](https://spring.io)
[![Build Status](https://img.shields.io/badge/jdk-15-orange)](https://www.oracle.com/java/technologies/javase/15-relnote-issues.html)
[![Build Status](https://img.shields.io/badge/vue-3-success)](https://vuejs.org/)

</div>

## Table of Contents

- [Introduction](#introduction)
- [Technology stack](#technology-stack)
- [Configuration](#configuration)
- [Usage](#usage)

## Introduction

Exploring the work of docker compose using the full stack task list application as an example.

## Technology stack

### Build tools

- Maven
- Webpack

### Backend

- Java 15
- Spring Boot
- Spring Data JPA
- MySQL

### Frontend

- Vue.js 3
- Tailwind CSS 2

## Configuration

To set up a configuration you have to add values to Environment variables.

### Configuration Values

- `SPRING_DATASOURCE_URL` - MySQL database url
- `SPRING_DATASOURCE_USERNAME` - MySQL database username
- `SPRING_DATASOURCE_PASSWORD` - MySQL database password

## Usage

#### Import the project (Intellij IDEA)

1. Create project from existing source
2. From the Project Structure dialog: Modules | new | Import Module | Select backend folder | Import module from external model
3. From the Project Structure dialog: Modules | new | Import Module | Select frontend folder | Create module from existing sources

#### Run Backend only
```sh
mvn --projects backend spring-boot:run
```

OR

You can add new Spring Boot configuration in Intellij IDEA by setting the **main class** as *BackendApplication*.

Spring Boot application will run at http://localhost:8080.

#### Run Frontend only

```sh
cd frontend
npm run serve
```

Vue.js application will run at http://localhost:8081.

OR

You can add new NPM configuration in Intellij IDEA by setting the **command** as *run* and **scripts** - *serve*.

## Copyright

Copyright © 2021 by [McForse](https://github.com/McForse)
