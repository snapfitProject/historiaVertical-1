<?php
require ('/home/snapfit/vendor/autoload.php');
$con = new MongoDB\Client;
    // Select Database
    if($con){
        $db = $con->users;
        // Select Collection
        $collection = $db->user;

       	$obj = $collection->find();

      // 	$array = iterator_to_array($cursor);
       foreach ($obj as $value) {
       	# code...
	       	echo "<pre>";
	       	var_dump(json_encode($value));
	       	echo "</pre>";
	      }
      }





?>