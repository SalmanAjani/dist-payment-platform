# 💳 Distributed Payment Processing Platform

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.x-brightgreen?style=flat-square&logo=spring-boot)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java21+-orange?style=flat-square&logo=java)](https://www.oracle.com/java/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16+-blue?style=flat-square&logo=postgresql)](https://www.postgresql.org/)
[![Redis](https://img.shields.io/badge/Redis-Caching-DC382D?style=flat-square&logo=redis)](https://redis.io/)
[![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED?style=flat-square&logo=docker)](https://www.docker.com/)
[![Kubernetes](https://img.shields.io/badge/Kubernetes--326CE5?style=flat-square&logo=kubernetes)](https://kubernetes.io/)
[![Microservices](https://img.shields.io/badge/Microservices-Architecture-FF6F00?style=flat-square&logo=icloud)](https://microservices.io/)

---

## 📋 Overview

A production-grade, distributed payment gateway inspired by Razorpay, designed to handle high-throughput payment processing across Card, UPI, and Net Banking.
Built with cloud-native microservices architecture using Spring Boot, Kafka, Redis, PostgreSQL, Kubernetes, and Docker.
The platform implements SAGA, Transactional Outbox, idempotency, encrypted card vaulting, webhook delivery, automated settlement, and end-to-end observability.

---

### 🎯 Key Highlights

* 💳 **Multi-Method Payments** — Card, UPI & Net Banking through a pluggable Strategy-based payment adapter architecture
* ⚡ **High-Throughput Processing** — Handles **1,000 TPS**, validated through JMeter load testing on Kubernetes
* 🔐 **PCI-Compliant Card Vault** — AES-256 envelope encryption with secure in-memory PAN handling
* 🔄 **SAGA & Transactional Outbox** — Reliable distributed transactions with guaranteed event delivery across PostgreSQL & Kafka
* 🛡️ **Idempotent Payments** — Redis SETNX-based idempotency preventing duplicate charges during retries and concurrent requests
* 🔔 **Webhook Engine** — HMAC-SHA256 signed webhooks with exponential backoff, 7 retry attempts, and DLQ replay
* 💰 **Automated Settlement** — Spring Batch-based nightly settlement processing with per-merchant settlement computation
* ☸️ **Kubernetes Autoscaling** — HPA-based autoscaling for payment adapter services under varying workloads
* 📊 **Full Observability** — Prometheus metrics, Grafana dashboards, and Zipkin distributed tracing across services
* 🧪 **Chaos Testing** — Built-in failure simulation layer for testing distributed system resilience and recovery

---

## ✨ Features

### Core Functionality

* **Multi-Method Payments** — Process Card, UPI, and Net Banking payments through a unified payment processing flow
* **Payment Adapter Architecture** — Pluggable Strategy-based adapters for integrating and routing different payment methods
* **Idempotent Payment Processing** — Redis SETNX-based idempotency to prevent duplicate charges during retries and concurrent requests
* **Distributed Transactions** — SAGA-based orchestration for managing multi-service payment workflows and failure scenarios
* **Reliable Event Publishing** — Transactional Outbox pattern for guaranteed Kafka event delivery alongside PostgreSQL transactions
* **Webhook Delivery** — Asynchronous merchant webhooks with HMAC-SHA256 signatures, exponential backoff, retries, and DLQ replay
* **Card Vaulting** — Secure storage of card data using AES-256 envelope encryption with PCI-compliant handling of raw PANs
* **Automated Settlement** — Spring Batch-based nightly settlement processing with per-merchant settlement computation
* **Payment Status Tracking** — End-to-end payment lifecycle management from initiation through processing, confirmation, and settlement

### Technical Features

* **Microservices Architecture** — Independently deployable Spring Boot services communicating through REST and Kafka
* **Event-Driven Architecture** — Apache Kafka for asynchronous communication and reliable inter-service event propagation
* **Kubernetes Orchestration** — Containerized deployment with HPA-based autoscaling for payment adapter workloads
* **Redis Idempotency** — Distributed idempotency control using atomic Redis SETNX operations
* **PostgreSQL Persistence** — Transactional relational storage for payments, merchants, settlements, and outbox events
* **Distributed Tracing** — Zipkin-based request tracing across services for debugging distributed workflows
* **Metrics & Monitoring** — Prometheus metrics with Grafana dashboards for system and payment-processing observability
* **Chaos Testing** — Failure simulation layer for validating recovery and reliability of distributed payment workflows
* **Load Testing** — JMeter-based performance validation supporting sustained throughput of up to **1,000 TPS**
* **API Documentation** — Swagger/OpenAPI documentation for REST APIs
