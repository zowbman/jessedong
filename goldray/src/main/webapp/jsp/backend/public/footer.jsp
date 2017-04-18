<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  </body>
  <script type="text/javascript">
    UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
    UE.Editor.prototype.getActionUrl = function(action) {
        if (action == 'uploadimage') {
           return '/backend/fileUpload/photo';
        } else if (action == 'uploadvideo') {
           return '/backend/fileUpload/video';
        } else {
           return this._bkGetActionUrl.call(this, action);
        }
    }
  </script>
</html>
