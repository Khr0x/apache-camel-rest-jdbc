Camel Main
==========

This example shows how to run Camel standalone via the built-in Main class.

The example also demonstrates how you can configure the Camel application
via Camel built-in dependency-injection that supports binding via the
`@BindToRegistry`, `@BeanInject` and `@PropertyInject` annotations.

Also notice how you can configure Camel in the `application.properties` file.

=== How to build

To build this project use

    mvn install

=== How to run

You can run this example using

    mvn camel:run

=== More information

You can find more information about Apache Camel at the website: http://camel.apache.org/


===== OpenShift ====

oc create configmap app-config \
  --from-literal=DB_HOST=127.0.0.1 \
  --from-literal=DB_NAME=test \
  --from-literal=DB_USER=root \
  --from-literal=DB_PASS=secret

=== Despliegue en OpenShift

1. Construye y sube la imagen Docker:
        docker build -t khrox/demojdbc:latest .
        docker push khrox/demojdbc:latest

2. Crea un ConfigMap en OpenShift con las variables de entorno:
        oc create configmap app-config \
            --from-literal=DB_HOST=127.0.0.1 \
            --from-literal=DB_NAME=test \
            --from-literal=DB_USER=root \
            --from-literal=DB_PASS=secret

3. Crea el archivo deployment.yaml en la raíz del proyecto con el siguiente contenido:

        apiVersion: apps/v1
        kind: Deployment
        metadata:
            name: demojdbc
        spec:
            replicas: 1
            selector:
                matchLabels:
                    app: demojdbc
            template:
                metadata:
                    labels:
                        app: demojdbc
                spec:
                    containers:
                        - name: demojdbc
                            image: tu-usuario/demojdbc:latest
                            ports:
                                - containerPort: 8080
                            envFrom:
                                - configMapRef:
                                        name: app-config

4. Aplica el deployment en OpenShift:
        oc apply -f deployment.yaml

5. Expón el servicio para acceder a la aplicación:
        oc expose deployment demojdbc --port=8080
        oc expose svc demojdbc

Tu aplicación tomará los valores del ConfigMap como variables de entorno y usará la imagen Docker que creaste.