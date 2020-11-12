<?php
$hostname ="localhost";
$database ="xxxdb";
$username ="root";
$password ="root";
 
$link = mysqli_connect($hostname, $username, $password) or trigger_error(mysql_error(), E_USER_ERROR);

mysqli_select_db($link, $database); 

?>
