jQuery.validator.addMethod("picRequired", function(value, element) {
    if($(element).closest('form').find("#id").length == 0){
        if(value.length == 0){
            return false;
        }
    }
    return true;
}, "*Please enter bannerImg");
$(function(){
    //产品分类验证
    $('#categoriesForm').validate({
        rules:{
            categoriesName:{
                required:true
            },
            cAbbreviate:{
                required:true
            }
       },
       messages:{
            categoriesName:{
                required:'*Please enter categoriesName'
            },
            cAbbreviate:{
                required:'*Please enter cAbbreviate'
            }
       }
    });
    //banner验证
    $('#bannerForm').validate({
        rules:{
            title:{
                required:true
            },
            bannerImg:{
                picRequired:true
            }
       },
       messages:{
            title:{
                required:'*Please enter title'
            }
       }
    });
});