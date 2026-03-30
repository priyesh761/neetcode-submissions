class Vehicle {
public:
    virtual string getType() = 0;
};

class Car : public Vehicle {
public:
    string getType() override {
        return "Car";
    }
};

class Bike : public Vehicle {
public:
    string getType() override {
        return "Bike";
    }
};

class Truck : public Vehicle {
public:
    string getType() override {
        return "Truck";
    }
};

class VehicleFactory {
public:
    virtual Vehicle* createVehicle() = 0;
};

class CarFactory : public VehicleFactory {
    Car* createVehicle() {
        return new Car();
    }
};

class BikeFactory : public VehicleFactory {
    Bike* createVehicle() {
        return new Bike();
    }
};

class TruckFactory : public VehicleFactory {
    Truck* createVehicle() {
        return new Truck();
    }
};
