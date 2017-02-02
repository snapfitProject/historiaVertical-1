<?php

 require ('/home/snapfit/vendor/autoload.php');
header('Content-type: application/json');


if($_SERVER['REQUEST_METHOD'] == 'POST')
{
    $entityBody = file_get_contents('php://input');

    //$body = json_decode(file_get_contents('php://input'),true);
    $body = json_decode($entityBody,true);

    //$entityBody = file_get_contents('php://input');

    foreach ($array as $key => $username) {
        # code...
        $User = $username;
    }
    foreach ($arry as $key => $Password) {
        $Pass = $Password;
    }
    

    if(empty($User))
    {

        $message = "Empty or invalid email address";
        echo json_encode(array('status'=> '1','message' => $message ));
         
    }

    if(empty($Pass)){
    
       
        $message = "Enter your password";
        
        echo json_encode(array('status'=> '2','message' => $message ));
     
    }else{
         $pass_hash = md5($Pass);
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
        
        if($row['Username'] == $User && $row['Password'] == $pass_hash){

           

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
}
/*function deliver_response($status, $status_message, $data)
{

        header("HTTP://1.1 $status $status_message");

        $response ['status' ]       =$status;
        $response['status message'] = $status_message;
        $response['data']           =$data;

        $json_response = json_encode($response);

        echo $json_response;
}*/
 ?>