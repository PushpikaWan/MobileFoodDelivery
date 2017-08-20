<?php

include 'DatabaseConfig.php';

 $con = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);
 $name = $_POST['Name'];
 $place = $_POST['Place'];
 $contact = $_POST['Contact'];
 $total = $_POST['Total'];
 $Date_Time = $_POST['DataTime'];
 
 $Sql_Query = "insert into Orders (Name,Place,Contact,Total,Date_Time) values ('$name','$place','$contact','$total','$Date_Time')";
 
 if(mysqli_query($con,$Sql_Query)){
    $last_id = $con->insert_id;
    echo $last_id;
 }
 else{
 
 echo '0';
 
 }
 mysqli_close($con);
?>