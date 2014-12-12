#!/bin/bash
#cagnosolutions@gmail.com:d10No335!@#$%

KEY="api:key-173701b40541299bd3b7d40c3ac6fd43"
URI="https://api.mailgun.net/v2/sandbox73d66ccb60f948708fcaf2e2d1b3cd4c.mailgun.org"

#curl -s --user $KEY \
#    $URI/messages \
#    -F from='John Doe <contact@example.org>' \
#    -F to=cagnosolutions@gmail.com \
#    -F subject='Mailgun Email API Test' \
#    -F text='Testing some Mailgun API awesomness!' \
#    --form-string html='<html>Testing some <a href="http://mailgun.com/">Mailgun</a> API awesomeness!</html>' \

curl -H "Authorization: Basic $KEY" -d '{"from":"John Doe <contact@example.com","to":"cagnosolutions@gmail.com","subject":"Testing123","text":"Testing456"}' $URI/messages



#curl -A 'Mandrill-Curl/1.0' -d '{"key":"tDtnQVJvVLraiEz1ipHCYg","message":{"html":"<p>Example HTML content<\/p>","text":"Example text content","subject":"example subject","from_email":"info@cagnosolutions.com","from_name":"Cagno Solutions","to":[{"email":"scottiecagno@gmail.com","name":"Scott Cagno","type":"to"}],"headers":{"Reply-To":"info@cagnosolutions.com"},"important":false,"track_opens":null,"track_clicks":null,"auto_text":null,"auto_html":null,"inline_css":null,"url_strip_qs":null,"preserve_recipients":null,"view_content_link":null,"bcc_address":"","tracking_domain":null,"signing_domain":null,"return_path_domain":null,"merge":false,"merge_language":"","global_merge_vars":[],"merge_vars":[],"tags":["notification"],"subaccount":null,"google_analytics_domains":[],"google_analytics_campaign":null,"metadata":{},"recipient_metadata":[],"attachments":[],"images":[]},"async":false,"ip_pool":"notification_pool","send_at":null}' 'https://mandrillapp.com/api/1.0/messages/send.json'
