# Spring Boot Application with Kubernetes Deployment
# Prometheus and Grafana setup to collect custom metrics 

![img_1.png](banner_not_prod.png)

This project provides a Spring Boot application with all the required Kubernetes files for deployment. The application helps deploy and set up the following components locally:

1. Postgres Database
2. Postgres Metrics Exporter
3. Prometheus Deployment
4. Grafana Deployment
5. Custom Application Deployment (using `micrometer-registry-prometheus` Spring library)

## Directory Structure

In the Kubernetes directory of this project, all directory names and file names start with numeric numbers that represent the order of execution. Follow that order to achieve the expected level of setup. You might need to adjust the storage class name and ingress class name as per your cluster.

## Deployment Steps

1. **Postgres Database**: Deploy the Postgres database using the provided Kubernetes manifests.
2. **Postgres Metrics Exporter**: Deploy the Postgres metrics exporter to collect database metrics.
3. **Prometheus**: Deploy Prometheus for scraping metrics from database and custom app.
4. **Grafana**: Deploy Grafana for visualizing the metrics collected by Prometheus.
5. **Custom Application**: Deploy the custom Spring Boot application which uses the `micrometer-registry-prometheus` library for exposing application metrics.

## Post-Deployment

After all the deployments are done, you can see all metrics available in Prometheus. You can use Grafana with the default `admin/admin` username and password to log in.

Once logged into Grafana, you will be able to create dashboards by selecting specific metrics and applying PromQL filters and conditions on them.

## Summary

This project serves as a simple example of setting up end-to-end resources in Kubernetes, including metrics collection and visualization.

## Additional Notes

- Adjust storage class names and ingress class names as per your cluster configuration.
- Ensure all deployments are executed in the specified order for proper setup.

---

This README provides an overview of the setup process for deploying and visualizing metrics using Spring Boot, Kubernetes, Prometheus, and Grafana.
