<?php

 require ('/home/snapfit/vendor/autoload.php');
//header('Content-type: application/json');

$entityBody = file_get_contents('php://input');
    $body = json_decode($entityBody,true);

//if($_SERVER['REQUEST_METHOD'] == 'POST')

if(empty($body)){
    $username   = $_POST['username'];
    $password   = $_POST['Password'];
  
}else{
    header('Content-type: application/json');
    
    foreach ($array as $value) 
    { 
        $username   = $value['username'];
        $password   = $value['Password'];
    }
}
    
    if(empty($username)){

        $message = "Empty or invalid email address";
        echo json_encode(array('status'=> '1','message' => $message ));
         
    }

    if(empty($password)){
    
       
        $message = "Enter your password";
        
        echo json_encode(array('status'=> '2','message' => $message ));
     
    }else{
         $pass_hash = md5($password);
    }

    $con = new MongoDB\Client;
    // Select Database
    if($con){
        $db = $con->users;
        // Select Collection
        $collection = $db->user;
        $filter = array(['Username' => $username,
                         'Password' => $pass_hash
                         ]);
        $options = [

            'projection' => ['Username' => 1], ['Password' => 1]
        ];
        $qry = new MongoDB\Driver\Query($filter, $options);
       
        $rows = $collection->find($qry);
       
        //iterator_to_array($cursor);
        foreach ($rows as $row) {
            # code...
           // print_r($row);
        }
        
        if($row['Username'] == $username && $row['Password'] == $pass_hash){

           

            $message = "You are successfully loggedIn";

        
           echo json_encode(array('status'=> '3','message' => $message ));
            
        }else{

          

            $message = "Wrong combination of username and password";
            
            
            echo array('message'=>$message);
            
           // var_dump($cursor);
        }
    }else{
        die("Mongo DB not connected!");
    }


 ?>