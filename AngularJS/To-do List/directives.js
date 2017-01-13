angular.module('todo').directive('todoTitle', function() {
    return {
      template: '<div class="col-lg-6"><h2>To-do List</h2></div>'
    };
});
  
angular.module('todo').directive('todoItem', function() {
    return {
      templateUrl: 'todoItem.tpl.html'
    };
  });
  
angular.module('todo').directive('todoFilters', function() {
  return {
    templateUrl: 'todoFilters.tpl.html'
  };
});  

angular.module('todo').directive('todoForm', function() {
  return {
    templateUrl: 'todoForm.tpl.html'
  };
});  

