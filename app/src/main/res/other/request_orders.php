<?php

include 'DatabaseConfig.php';

 $con = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);
 
 $Sql_Query = "SELECT A.*,B.*,C.* FROM OrderedItems A
LEFT OUTER JOIN Orders B ON (A.Order_ID = B.Order_ID)
LEFT OUTER JOIN Items C ON (A.Item_ID = C.Item_ID)";

 $resultsd = mysqli_query($con,$Sql_Query);

 $orders_array = array();

 while ($row = mysqli_fetch_row($resultsd)){
  $orders_array[] = array(
    "Order_ID" => $row[0],
    "Item_ID" => $row[1],
    "Price" => $row[2],
    "Quantity" => $row[3],
    "TotalLine" => $row[4],
    "BuyerName" => $row[6],
    "Place" => $row[7],
    "Contact" => $row[8],
    "Total" => $row[9],
    "ItemName" => $row[13],
    "DateTime" => $row[11]
 );
 }

// if(mysqli_num_rows($resultsd)==0){
//    echo 'No data entries';
// }
echo json_encode(array("result"=>$orders_array));
 mysqli_close($con);
?>