<?php

include 'DatabaseConfig.php';

 $con = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);
 
 $Sql_Query = "SELECT * FROM Items";
 $resultsd = mysqli_query($con,$Sql_Query);

 $Items_array = array();
 while ($row = mysqli_fetch_row($resultsd)){
   $Items_array[] = array(
    "Item_ID" => $row[0],
    "Name" => $row[1],
    "Category" => $row[2],
    "Availability" => $row[3],
    "Price" => $row[4] );
 }

// if(mysqli_num_rows($resultsd)==0){
//    echo 'No data entries';
// }
echo json_encode(array("result"=>$Items_array));
 mysqli_close($con);
?>