$(function() {
  pushGacha();
});

var pushGacha = function() {
  $('#gacha_button').on('click', function(event) {
    console.log("push gacha");
    event.preventDefault();
    var feedBack = {
      dataType: 'json',
      success: function(jsonData, textStatus, jqXHR) { 
        showGachaResult(jsonData);
      },
      error: onError
    }

    jsRoutes.controllers.GachaController.pickup().ajax(feedBack);
  }); 
};

var onError = function(error) {
  alert("error"+error);
}

var showGachaResult = function(jsonData) {
  console.log("pick up");
  var data = JSON.stringify(jsonData);
  console.log(data);
  var items = new Array();
  var len = jsonData.result.length;
  $("#gacha-result").children().remove();
  if (len == 0) {
    return;
  }
  for (var i = 0; i < len; i++) {
    items.push("<div>");
    items.push("ID: "+jsonData.result[i].id);
    items.push("NAME: "+jsonData.result[i].name);
    items.push("SENTENCE: "+jsonData.result[i].sentence);
    items.push("</div>");
  }
  $("#gacha-result").append(items.join(''));
}