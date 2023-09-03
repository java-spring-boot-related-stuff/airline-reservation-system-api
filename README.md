# Airline Reservation System APIs

### Entities
1. Flight
2. Pilot
3. Airport
4. Flight Schedules
5. FLight Bookings (Tickets/Orders)
6. Customer
7. Admin

### Required APIs & Functionalities:
1. Onboard New Flight
2. Update Flight Details
3. Onboard New Pilot
4. Update Pilot Details
5. Register New Airport
6. Update Airport Details
7. Create a new Flight Schedule
8. Update Existing Flight Schedule
9. Flight Inquiry Based Upon Filters (Source Airport, Destination Airport, Departure Date, Sort By Departure Time, Sort By Arrival Time)
10. Flight Booking For Customer
11. Cancel Flight Booking By Customer
12. Fetch Booking History (Support For Various Filters Like Filter By Status, Source Airport, Dest Airport, Sort By Booking Time ASC/DESC etc.)


### NFR:

1. Max Response Time: 5sec
2. Throughput: 200 req/sec
3. Max Acceptable CPU Utilization: 80%
4. Max Acceptable Memory Utilization: 1024MB
5. Uptime: 99.99%
6. Disaster Recovery: Active-Active Configuration With atleast 2 Geographically Separated Cloud Regions
7. Horizontal Scaling: Auto Scaling Enabled With Min=2 and Max=5 Replicas
8. Data Protection: Min TLS 1.2. Http Redirection to HTTPS
9. Logging: Errors & Privileged User Operations Must Be Logged and Logs Must be Transmitted to a secure storage (AWS Cloudwatch/Devo/Newrelic)
10. Monitoring: Application Matrices Must be published to NewRelic and alerts must be configured.
11. Code Quality: No Snyk Code High Vuln