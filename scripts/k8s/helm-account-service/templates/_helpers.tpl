{{/*
Create a default fully qualified account-service name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
*/}}
{{- define "myfintech.accountService.fullName" -}}
{{- $name := .Chart.Name -}}
{{- printf "%s-%s-%s" .Release.Name $name .Values.application.name | trunc 63 | trimSuffix "-" -}}
{{- end -}}
