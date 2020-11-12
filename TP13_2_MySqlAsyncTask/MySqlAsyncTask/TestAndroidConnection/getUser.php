<?php 
  require_once('Connection.php'); 
  $id = $_GET['id'];
  $query_search = "select * from users where id = '".$id."'";
  $query_exec = mysqli_query($link, $query_search) or die(mysqli_error());
  $rows = mysqli_num_rows($query_exec);
 
  if($rows > 0) { 
	while(@$row=mysqli_fetch_array($query_exec)){
	 	echo $row['FirstName'] . " " . $row['LastName'];
	} 
  }
  else  {  echo "N"; }
?>