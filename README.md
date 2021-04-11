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
- Docker compose

### Backend

- Java 15
- Spring Boot
- Spring Data JPA
- PostgreSQL

### Frontend

- Vue.js 3
- Tailwind CSS 2

## Configuration

To set up a configuration you have to add values to Environment variables.

### Configuration Values

Files .env.template contain all necessary variables.

## Usage

#### Run through Docker compose
```sh
docker-compose -d
```

#### Run Backend only
```sh
mvn --projects backend spring-boot:run
```

#### Run Frontend only

```sh
cd frontend
npm run serve
```

## Copyright

Copyright © 2021 by [McForse](https://github.com/McForse)
