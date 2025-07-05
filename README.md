# ecommerce_console_system

A simple Java console-based e-commerce system demonstrating core concepts such as products, carts, customers, checkout, shipping, and expiration strategies.

## my notes while working in this task 

- [MyThinking.md](MyThinking.md) -design decisions

## Project Structure

The system is organized into modular packages, each handling a distinct domain:

```
org.example
├── cart/              # Shopping cart management
├── customer/          # Customer domain and account management
├── product/           # Product catalog and management
│   ├── expire/        # Product expiration strategies
│   └── shipping/      # Shipping classification strategies
├── services/          # Business logic and transaction services
└── Main.java          # Application entry point
```

## Features

- **Product Management:** Supports expirable and non-expirable products, shippable and non-shippable items.
- **Cart System:** Add products to a cart with quantity checks and expiration validation.
- **Customer Accounts:** Customers have balances and can make purchases if they have sufficient funds.
- **Checkout Process:** Calculates subtotal, shipping costs, and updates product quantities and customer balance.
- **Shipping Calculation:** Only shippable items are considered for shipping cost.
  

## some usecases 
![image](https://github.com/user-attachments/assets/48a418d4-d20c-4a89-a377-454dc88a2383)


![image](https://github.com/user-attachments/assets/86379b90-7726-43f2-b9d3-90608d1faa05)


![image](https://github.com/user-attachments/assets/3d8343b5-260e-4a33-a3ab-c0b519e271e9)




![image](https://github.com/user-attachments/assets/5463e2fa-e0c3-48eb-af9c-373605abb7af)


![image](https://github.com/user-attachments/assets/699e59bd-6fa0-494d-8d1a-3c1f29e92967)


![image](https://github.com/user-attachments/assets/67b2a074-b97a-4530-997f-c13cdd677ad1)



## TO-Do
- [ ] add unit test for whole the logic
- [ ] enhance exception handling
