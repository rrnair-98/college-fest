class Callbacks{
    constructor(success, error){
        this.success = success;
        this.error = error;
    }
}
class JsonKeys{
    /**
     *@param key - the key of the json to be sent
     *@param id - the dom id of the element whose value must be sent
     *@param splitChar - the char to be used to split strings
     *@param isArray- if set , the FormHandler uses csvs to create a jsonArr
     ***/
    constructor(key, id, splitChar,isArray){
        this.key = key;
        this.id = id;
        this.isArray = isArray;
        this.splitChar = splitChar;
    }
}
class FormHandler{
    /**
     This class is handles form submission events and triggers ajax requests
     It 'watches' the ids provided in formContentIds and passes this as a json to
     the server.
     keysList is the json key used to be sent to the server
     **/
    constructor(url, formId, httpMethod, callbacks , jsonKeysList){
        this.baseUrl = url;
        this.formId = formId;
        this.callbacks = callbacks;
        this.httpMethod = httpMethod;
        console.log(this.httpMethod);
        this.jsonKeysList = jsonKeysList;
        this.json={};
    }
    constructJson(){
        var json={};
        for(var i =0 ; i< this.jsonKeysList.length; i++){
            var current = this.jsonKeysList[i];
            var key = current.key;
            var data=$("#"+current.id).val();
            var temp ={};
            var splitChar = current.splitChar;
            if(current.isArray){
                data = data.split(splitChar);
            }
            temp[key]=data;
            $.extend(json,temp );
        }
        return json;
    }

    bindAjax(){
        console.log(this.formId);
        console.log(this);
        var me=this;
        $("#"+this.formId).on('submit', function(event){

            event.preventDefault();
            a=null;
            $.ajaxSetup({
                beforeSend: function(xhr, settings) {
                    function getCookie(name) {
                        var cookieValue = null;
                        if (document.cookie && document.cookie != '') {
                            var cookies = document.cookie.split(';');
                            for (var i = 0; i < cookies.length; i++) {
                                var cookie = jQuery.trim(cookies[i]);
                                // Does this cookie string begin with the name we want?
                                if (cookie.substring(0, name.length + 1) == (name + '=')) {
                                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                                    break;
                                }
                            }
                        }
                        return cookieValue;
                    }
                    console.log("here");

                    xhr.setRequestHeader("Content-Type", "application/json");
                    console.log("DONE WITH HEADERS");
                }
            });

            console.log("METHOD " +me.httpMethod);
            console.log(me.constructJson());
            $.ajax({
                method: me.httpMethod,
                url:me.baseUrl,
                crossOrigin:true,
                crossDomain:true,
                data: JSON.stringify(me.constructJson()),
                success:me.callbacks.success,
                error:me.callbacks.error
            });

        });
    }

}
function dispState(someMsg, data){
    console.log(someMsg);
    console.log(data);
}


