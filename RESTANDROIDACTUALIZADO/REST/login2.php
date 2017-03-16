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
           //print_r($row);
            if($row['Username'] == $username && $row['Password'] == $pass_hash){
                $usercorrect = true;
                $user_found = $row;
            }else if($row['Username'] == $username && $row['Password'] == $password && $row['Admin'] == true){
                $user_admin = true;
                $user_admin_found = $row;
            }
        }
        
        
        if($usercorrect){ 
            echo "You are successfully loggedIn <br/>"; ?>
            
        <html>
            <head>
                <title>
                    Log in
                </title>
            </head>
         <body>
            <div class="container">
                <div class="col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                    </div>
                            <div class="panel-body">
                                <form action="config.php?id=<?php echo $user_found['_id']?>" method="POST">
                                    <div class:"form-group">
                                        <input type="password" name="Password" id="" class="Password" placeholder="Password">
                                    </div>
                                    <div class:"form-group">
                                        <input type="password" name="Repeat Password" id="" class="Password" placeholder="Repeat Password">
                                    </div>
                                    <div class:"form-group">
                                        <input type="submit" value="Delete" class="btn btn-danger">
                                    </div>
                                </form>
                            </div>
                    </div>
                </div>
            </div>
          </body>
        </html>
          
     <?php   }else if($user_admin){ 
                var_dump("Hi Admin");
                ?>
                <html>
            <head>
                <title>
                    Log in
                </title>
            </head>
         <body>
            <div class="container">
                <div class="col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                    </div>
                            <div class="panel-body">
                                <form action="listar_usuarios.php" method="POST">
                                    <div class:"form-group">
                                        <input type="submit" value="Listar Usuarios" class="btn btn-danger">
                                    </div>
                                </form>
                            </div>
                    </div>
                </div>
            </div>
          </body>
        </html>
      <?php   }else{
                echo "Wrong combination of username and password <br/>";
               // var_dump($cursor);
            }
    }else{
        die("Mongo DB not connected!");
    }
}else{
    echo "No se ha conectado";
}
?>
