<?php
require_once 'config.php';
class API {
    function select(){
        $db = new Connect;
        $appointments = array();
        $data = $db->prepare('SELECT * FROM appointments,advisors ORDER BY appointment_id');
        $data->execute();

        //$advisordata= $db->prepare('SELECT advisor_fname FROM advisors ORDER BY advisor_id');
        while($OutputData = $data->fetch(PDO::FETCH_ASSOC)){
           // $advid = $OutputData['advisor_id'];
            //$advisorname = $db->prepare("SELECT advisor_fname FROM advisors WHERE advisor_id = '$advid'");
        $appointments[$OutputData['appointment_id']] = array(
                'appointment_id' => $OutputData['appointment_id'],
                'advisor_fname' => $OutputData['advisor_fname'],
                'advisor_lname' => $OutputData['advisor_lname'],

                'advisor_id' => $OutputData['advisor_id'],
                'request_info' => $OutputData['request_info'],
                'response' => $OutputData['response']
                );


        }
        return json_encode($appointments);
    }

}


$API = new API;
header('Content-Type: application/json');
echo $API->select();

?>