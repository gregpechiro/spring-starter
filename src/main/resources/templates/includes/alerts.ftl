<script src="/static/js/notify.min.js"></script>
<script src="/static/js/notify-metro.js"></script>
<script src="/static/js/notification.js"></script>

<#if alert??>
	<script type="text/javascript">
		$.Notification.autoHideNotify('info', 'top right', '${alert}');
	</script>
<#elseif alertError??/>
	<script type="text/javascript">
		$.Notification.autoHideNotify('error', 'top right', '${alertError}');
	</script>
<#elseif alertSuccess??/>
	<script type="text/javascript">
		$.Notification.autoHideNotify('success', 'top right', '${alertSuccess}');
	</script>
<#elseif alertWarning??/>
	<script type="text/javascript">
		$.Notification.autoHideNotify('warning', 'top right', '${alertWarning}');
	</script>
</#if>