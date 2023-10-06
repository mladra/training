### About

The idea of the system is to simulate work of car industry with the use
of some fine technologies and different communication methods.

### Communication

- [REST] mechanic-service asks car-info-service about information about serviced car
- [REST] mechanic-service asks car-parts-supplier for particular part which needs to be replaced
- [Kafka] car-parts-supplier sends request to car-parts-factory for another delivery of parts 
- [Kafka] car-parts-factory sends information about delivery on desired topic

### Modules description

#### Mechanic Service
[//]: # (TODO: Add description)

#### Car Info Service

Stores information about vehicles, e.g.:

- brand
- model
- year of production
- horsepower
- parts

#### Car Parts Supplier
[//]: # (TODO: Add description)

#### Car Parts Factory
[//]: # (TODO: Add description)

