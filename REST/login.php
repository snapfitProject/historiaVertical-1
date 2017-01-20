<?php

 require ('/home/snapfit/vendor/autoload.php');


if(isset($_POST['username']) && isset($_POST['Password'])){
    $username = $_POST['username'];
    $password = $_POST['Password'];
   
    if(empty($username)){
        echo "Empty or invalid email address <br/>";
    }
    if(empty($password)){
        echo "Enter your password <br/>";
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
            echo "You are successfully loggedIn <br/>";
        }else{
            echo "Wrong combination of username and password <br/>";
           // var_dump($cursor);
        }
    }else{
        die("Mongo DB not connected!");
    }
}
?>
