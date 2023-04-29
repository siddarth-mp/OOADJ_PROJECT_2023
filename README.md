# OOADJ_PROJECT_2023

## Synopsis :

This is a Java project which has been done done as a part of OOADJ course of 6th Sem. The project entitled 'Hotel Management system' is a centralized system which offers multiple views from a hotel management perspective, namely there are 4 views : Hotel Manager, System Admin, User (Unregistered with a hotel) and finally a customer,who has registered with a hotel.

To Begin with, a System admin is the one who has complete access to the system ,he is the one who can observe/resolve issues which are reported by customers, he is the one who can add hotels and their respective managers, he also has several other views of analysis, in case hotel manager fails to login with a hotel, admin can takeover and carry on with manager's work by logging into that particular hotel

User (Unregistered customer) has a view to compare different hotels, view details about hotels in prior so that they can decide upon which hotel to choose
In addition to that there's also a pickup service offered to customers who are a part of a particular hotel,and can avail the same service
That's a brief introduction about our project

There's also a Analysis view for each of view cretaed which displays room availability in a hotel, employee analysis for hotel manager, Hotel's ratings comparison for system admin view

## Implementation Details :

We have used Java Swing AWT along with MySQL database and adhered to MVC , Singleton,Factory design ,Chain of Responsibility design patterns. In addition design principles like SRP,OCP have been followed. Overall the system offers customers/users to efficiently look into various hotels and view its details so that they can accommodate in one among them. Analysis component has been included as a part of requirement showing various departmental, room availability ,employee staff analysis, using which hotel managers can take necessary actions.
For plotting of certain charts, we have used JFreeChart library, and plotted histogram,pie chart,bar plot for analysis view, we created a matrix view for room availability using Table grid cells.

## Use case diagram : 
![st1](https://user-images.githubusercontent.com/74816547/235312532-2cd91154-a5ee-4798-9d9d-cc947313d61c.png)

## Class Diagran : 
![st45](https://user-images.githubusercontent.com/74816547/235312606-388178b9-c811-4b8f-be3d-5f940b04131d.png)

## Activity Diagram  :
![st56](https://user-images.githubusercontent.com/74816547/235312675-ccf9d8a1-adff-46c5-9fd9-992ab6ad7034.png)


## State Diagram : 
![stre](https://user-images.githubusercontent.com/74816547/235312786-76b9d1fc-ade1-423b-8ba9-93f6e7a7b90b.png)


