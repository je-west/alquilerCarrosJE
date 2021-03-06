@Library('ceiba-jenkins-library') _
pipeline{
	// any -> tomaria slave 5 u 8
	// Para mobile se debe especificar el slave -> {label 'Slave_Mac'}
	// Para proyectos de arus se debe tomar el slave 6 o 7 -> {label 'Slave6'} o {label 'Slave7'}
    agent any


    options {
        buildDiscarder(logRotator(numToKeepStr: '3'))
        disableConcurrentBuilds()
        //gitLabConnection('GitCeiba')
    }

    environment {
        PROJECT_PATH_BACK = 'microservicio'
    }

    triggers {
        // @yearly, @annually, @monthly, @weekly, @daily, @midnight, and @hourly o definir un intervalo. Ej: H */4 * * 1-5
        pollSCM('') //define un intervalo regular en el que Jenkins debería verificar los cambios de fuente nuevos
    }

    tools {
        jdk 'JDK11_Centos'
    }

    // Parametros disponibles en jenkins
     /*parameters{
            string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
            text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')
            booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')
            choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
            password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a passwor')
     }*/

     stages{
             stage('Checkout') {
                 steps {
                     echo '------------>Checkout<------------'
                         checkout([
                             $class: 'GitSCM',
                             branches: [[name: '*/main']],
                             doGenerateSubmoduleConfigurations: false,
                             extensions: [],
                             gitTool: 'Default',
                             submoduleCfg: [],
                             userRemoteConfigs: [[
                                 credentialsId: 'GitHub_je-west',
                                 url:'https://github.com/je-west/alquilerCarrosJE'
                             ]]
                         ])
                 }
             }

        stage('Compilacion y Test Unitarios'){
            // El "parallel" es si vamos a correr los test del frontend en paralelo con los test de backend, se configura en otro stage dentro de parallel
            //parallel {
                //stage('Test- Backend'){
                    steps {
                        echo '------------>Test Backend<------------'
                        dir("${PROJECT_PATH_BACK}"){
                            sh 'chmod +x gradlew'
                            sh './gradlew clean'
                            sh './gradlew --stacktrace test'
                        }
                    }
                    //post{
                    //    always {
                    //        junit '**/build/test-results/test/*.xml' //Configuración de los reportes de JUnit
                    //    }
                    //}
                //}
                /*
                stage('Test- Frontend'){
                    steps {
                        echo '------------>Test Frontend<------------'
                        dir("${PROJECT_PATH_FRONT}"){
                            // comando ejecucion test
                        }
                    }
                }
                */
            //}
        }
		
		stage('Static Code Analysis') {
			steps{
				sonarqubeMasQualityGatesP(sonarKey:'co.com.ceiba.adn:alquilerVehiculos',
				sonarName:'CeibaADN-alquilerVehiculos-jhon.carmona',
				sonarPathProperties:'./sonar-project.properties')
			}
		}

        stage('Build'){
            parallel {
                stage('construcción Backend'){
                    steps{
                        echo "------------>Compilación backend<------------"
                        dir("${PROJECT_PATH_BACK}"){
                            sh './gradlew build -x test'
                        }
                    }
                }
            }
         }
    }

    post {
        failure {
        echo '-----This will run only if failed----'
            mail(
                to: 'jhon.carmona@ceiba.com.co',
                body:"Build failed in Jenkins: Project: ${env.JOB_NAME} Build /n Number: ${env.BUILD_NUMBER} URL de build: ${env.BUILD_NUMBER}/n/nPlease go to ${env.BUILD_URL} and verify the build",
                subject: "ERROR CI: ${env.JOB_NAME}"
            )
            //updateGitlabCommitStatus name: 'IC Jenkins', state: 'failed'
        }
        success {
            echo '---This will run only if successful---'
            //updateGitlabCommitStatus name: 'IC Jenkins', state: 'success'
            junit '**/build/test-results/test/*.xml'

        }
    }
}
