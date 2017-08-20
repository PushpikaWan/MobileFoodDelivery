<?php

include 'DatabaseConfig.php';

 $con = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);

 $Order_ID = (int)($_POST['Order_ID']);
 $Array_Length = (int)($_POST['Array_Length']);
 $Item_Array = $_POST['Item_Array'];
 $Quantity_Array = $_POST['Quantity_Array'];
 $Price_Array = $_POST['Price_Array'];
 $Total_Line_Array = $_POST['Total_Line_Array']; 

 $Item_Pieces = explode(",", $Item_Array);
 $Quantity_Pieces = explode(",", $Quantity_Array);
 $Price_Pieces = explode(",", $Price_Array);
 $Total_Line_Pieces = explode(",", $Total_Line_Array);

 for( $j = 0; $j<= $Array_Length; $j++ ) {
     $Sql_Query = "insert into OrderedItems (Order_ID,Item_ID,Price,Quantity,TotalPrice) values ($Order_ID, '$Item_Pieces[$j]','$Quantity_Pieces[$j]','$Price_Pieces[$j]','$Total_Line_Pieces[$j]')";
 mysqli_query($con,$Sql_Query);
}
 mysqli_close($con);
?>