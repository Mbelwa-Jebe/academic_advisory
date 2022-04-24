<?php
require_once 'config.php';
class API {
    function select(){
        $db = new Connect;
        $reports = array();
        $data = $db->prepare('SELECT * FROM consultations,advisors,students GROUP BY consultation_id');
        $data->execute();

        while($OutputData = $data->fetch(PDO::FETCH_ASSOC)){

            array_push($reports,array(

                'consultation_id' => $OutputData['consultation_id'],
                    'student_id' => $OutputData['student_id'],
    
                    'student_fname' => $OutputData['student_fname'],
                    'student_lname' => $OutputData['student_lname'],
    
                    'advisor_fname' => $OutputData['advisor_fname'],
                    'advisor_lname' => $OutputData['advisor_lname'],
    
                    'advisor_id' => $OutputData['advisor_id'],
                    'report_date' => $OutputData['report_date']
            ));
       
        }

       $reports = [ 'reports'=> $reports];

        echo  json_encode($reports,JSON_PRETTY_PRINT,JSON_FORCE_OBJECT);
    }

}


$API = new API;
header('Content-Type: application/json');
echo $API->select();

?>