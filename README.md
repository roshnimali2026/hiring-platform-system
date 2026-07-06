# Hiring Platform - Microservices Architecture

A scalable and production-oriented Hiring Platform built using **Spring Boot Microservices**. This project is being 
developed step by step to understand how enterprise-level backend systems are designed, implemented, and deployed.

The goal is not only to build functional features but also to learn production-ready concepts such as Service Discovery, 
API Gateway, Load Balancing, Security, Caching, Batch Processing, Docker, and Performance Optimization.

# Project Objectives

- Learn Microservices Architecture
- Build independent Spring Boot services
- Understand Service Discovery using Eureka
- Implement API Gateway as a single entry point
- Demonstrate Client-side Load Balancing
- Build scalable backend services
- Follow production-level project structure and coding practices


# Current Progress

## ✅ Day 1 - Project Setup

Completed:

- Maven Multi-Module Project Setup
- Parent Aggregator Project
- Service Registry (Eureka Server)
- Candidate Service
- API Gateway
- Docker Setup
- MySQL Container
- Redis Container
- Spring Boot 3.2.4 Configuration
- Java 21 Configuration


---

## ✅ Day 2 - Load Balancer Proof of Concept

Completed:

- Multiple Candidate Service Instances
- Eureka Service Registration
- Spring Cloud LoadBalancer Integration
- Gateway Routing Configuration
- Horizontal Scaling Demonstration - Created 3 Instances of candidate service

---

# Tech Stack

| Technology | Version |
|------------|----------|
| Java | 21 |
| Spring Boot | 3.2.4 |
| Spring Cloud | 2023.0.1 |
| Maven | 3.x |
| Eureka Server | Netflix Eureka |
| Spring Cloud Gateway | Latest compatible |
| Spring Cloud LoadBalancer | Latest compatible |
| MySQL | 8.x |
| Redis | 7.x |
| Docker | Latest |


Current Architecture

Client
│
▼
API Gateway (8080)
│
▼
Spring Cloud LoadBalancer
│
▼
Eureka Server
│
┌──────┼──────────┐
▼      ▼          ▼
Candidate-1 Candidate-2 Candidate-3


---

# Project Structure

```
hiring-platform/
│
├── pom.xml                     (Parent Aggregator)
│
├── service-registry/
│   ├── pom.xml
│   └── Spring Boot Application
│
├── api-gateway/
│   ├── pom.xml
│   └── Spring Boot Application
│
├── candidate-service/
│   ├── pom.xml
│   └── Spring Boot Application
│
├── interview-service/
│   └── (Planned)
│
└── docs/
```

---
# Modules

## 1. Service Registry

Technology

- Spring Cloud Netflix Eureka Server

Responsibilities

- Service Registration
- Service Discovery
- Instance Health Monitoring

Default URL
```
http://localhost:8761
```

---

## 2. API Gateway

Technology

- Spring Cloud Gateway
- Spring Cloud LoadBalancer

Responsibilities

- Single Entry Point
- Request Routing
- Client-side Load Balancing
- Future Authentication
- Future Request Validation
- Future Logging
- Future Security Filters

Default URL

```
http://localhost:8080
```

---
## 3. Candidate Service

Technology

- Spring Boot
- Spring Web

Responsibilities

- Candidate APIs
- Candidate Registration (Upcoming)
- Candidate Profile (Upcoming)

Registration Flow

Client
│
▼
Controller
│
▼
Bean Validation
│
▼
Business Validation
│
├── Check Duplicate Email
└── Check Duplicate Phone
│
▼
Mapper
│
▼
Repository
│
▼
MySQL
│
▼
Mapper
│
▼
Response DTO
│
▼
Standard API Response

```
GET /candidate/test
```

---
# Current Request Flow

```
Client

      │

      ▼

API Gateway

      │

      ▼

Eureka Server

      │

      ▼

Spring Cloud LoadBalancer

      │

      ▼

Candidate Service Instance
```

---

# Implemented Concepts

## Maven Multi Module Project

The application follows a parent-child Maven structure where all microservices are managed under a single parent project.

Benefits

- Centralized dependency management
- Easy build management
- Consistent versions
- Better scalability

---

## Service Discovery

Implemented using Netflix Eureka.

Each microservice automatically registers itself with Eureka during startup.

Benefits

- Dynamic service registration
- No hardcoded URLs
- Easy horizontal scaling

---
## API Gateway

Implemented using Spring Cloud Gateway.

Benefits

- Single entry point
- Centralized routing
- Future authentication
- Future rate limiting
- Future logging
- Future monitoring

---
## Client Side Load Balancing

Implemented using Spring Cloud LoadBalancer.

The Gateway forwards requests to available Candidate Service instances using the load balancing strategy provided by Spring Cloud.

Benefits

- Horizontal scaling
- Better availability
- Improved performance
- Fault tolerance

---
# Docker

Docker Containers

- MySQL
- Redis

Purpose

- Local development
- Consistent environment
- Easy deployment
- Production-like setup

---

# APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | /candidate/test | Test Candidate Service |

---
# Upcoming Features

- JWT Authentication
- Candidate Management
- Assessment Module
- Interview Scheduling
- Redis Caching
- Rate Limiting
- Circuit Breaker
- Spring Batch
- Docker Compose
- Load Testing
- Kafka Integration
- Monitoring
- Distributed Tracing

---

# Learning Goals

This project is focused on understanding enterprise backend development concepts including:

- Microservices Architecture
- Maven Multi-Module Projects
- Service Discovery
- API Gateway
- Client-side Load Balancing
- Docker
- Spring Cloud Ecosystem
- Production Ready Backend Design

---

# Project Status

| Feature | Status |
|----------|--------|
| Maven Multi Module | ✅ |
| Service Registry | ✅ |
| API Gateway | ✅ |
| Candidate Service | ✅ |
| Docker | ✅ |
| MySQL | ✅ |
| Redis | ✅ |
| Load Balancer | ✅ |
| JWT Authentication | ⏳ |
| Assessment Module | ⏳ |
| Interview Module | ⏳ |
| Redis Cache | ⏳ |
| Rate Limiting | ⏳ |
| Circuit Breaker | ⏳ |
| Spring Batch | ⏳ |
| Docker Compose | ⏳ |
| Load Testing | ⏳ |

# Author

**Roshni**

This repository documents my journey of building a production-ready microservices-based Hiring Platform while learning 
enterprise backend development with Spring Boot and Spring Cloud.

