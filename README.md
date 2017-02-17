# mobileprogramming

Just all the project I have in mobile programming class

#FirstClass

I did a simple application with four widget, 3 TextView, 1 EditText, 1 Button 1 ImageView.
On the First activity we can fill with our name then validate.
It will open a second activity that will say thank you *name*

All the screenshot are available here :
https://github.com/yanisbourabaa/mobileprogramming/blob/master/preview/firstclass/main.png
https://github.com/yanisbourabaa/mobileprogramming/blob/master/preview/firstclass/mainyanis.png
https://github.com/yanisbourabaa/mobileprogramming/blob/master/preview/firstclass/secondyanis.png
https://github.com/yanisbourabaa/mobileprogramming/blob/master/preview/firstclass/mainjohn.png
https://github.com/yanisbourabaa/mobileprogramming/blob/master/preview/firstclass/secondjohn.png

#SecondClass

this is an application that show a menu. You can add starters, entrees, and drinks. Then when you click on pay, you can see your cart. Finally you check out and you can see the final price.

see all the previews in : https://github.com/yanisbourabaa/mobileprogramming/tree/master/preview/secondclass

there are 3 activities : MainActiviy, Cartactivity, FinishActivity.
https://github.com/yanisbourabaa/mobileprogramming/blob/master/SecondClass/app/src/main/java/com/example/yanisbourabaa/secondclass/MainActivity.java
https://github.com/yanisbourabaa/mobileprogramming/blob/master/SecondClass/app/src/main/java/com/example/yanisbourabaa/secondclass/cart/CartActivity.java
https://github.com/yanisbourabaa/mobileprogramming/blob/master/SecondClass/app/src/main/java/com/example/yanisbourabaa/secondclass/finish/FinishActivity.java

I also have a fragment : ProductListFragment that takes a list of product and show it. 
https://github.com/yanisbourabaa/mobileprogramming/blob/master/SecondClass/app/src/main/java/com/example/yanisbourabaa/secondclass/ProductListFragment.java

I use a CartManager that is a singleton, it allows me to stock the product models : 
https://github.com/yanisbourabaa/mobileprogramming/blob/master/SecondClass/app/src/main/java/com/example/yanisbourabaa/secondclass/manager/CartManager.java

I use putExtra() between the CartActivity and the finishActivity.
