#Fawry Task
# In this file i will show my thinking while working in this project.
## first stage understand the statement well
* the system show there is various type of products they may be have expire date or not
  and may be shippable or not.
* we must design it to have ability to scale with more types.
  ==> as i read in head first design patterns and this is the use case of Strategy pattern.
    * customer will have name and balence  and we need to add check balance method , and subtract order price form balance method
    *  products added to cart class which has the business logic
    * start to implement shipping service and it must implement shipping item interface(take care this is not optional)
    *  implement checkout Service## in paper start to design caroke UML diagram

## start implementation
- i searched what is the bast practice for naming the interface of strategy class
- i have opinion that we don't need to make gets and sets for all class attributes
-  search about java streams to get subtotal
- after search i will use it as black box for now and added it for my TO DO list.
- to keep code readable i will shipping service with static method to make nested class with main
- i will assume shipping cost = 2;
- for future add expption handler
- write unit test for the logic


