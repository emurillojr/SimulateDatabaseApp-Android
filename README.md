# SimulateDatabaseApp-Android
Simulate a Database application using Intents <br>
Modify your Order Entry System part 1 to add the following features <br>
For the Orders Class <br>
To pass it between activities, make it Parcelable <br>
For the Main Activity <br>
• Add a “Get Results” button.  When the user clicks on it, they will go to another window <br>
• Leave your Save button from Order Entry System part 1 if you want but do not have it save anything <br>
• The Get Results button will take the new order and pass it to the Results activity <br>
• The Main Activity will list the number of orders saved by getting the information passed back from the Results Activity <br>
The Results Activity will have the following specifications <br>
• You will store all of your orders in a static ArrayList called CandyOrders  <br>
• The order passed into Results Activity from your Main Activity will be added to the CandyOrders array described above <br>
• It will then list the first name, last name and type of chocolate for each order via the ListView component  <br>
(hint, create an ArrayAdapter and set it to the ListView <br>
• There will be a Send Count To Main button that will pass back to the Main Activity the number of orders <br>
• There will only be two components in the Results Activity – the button and the ListView <br>
