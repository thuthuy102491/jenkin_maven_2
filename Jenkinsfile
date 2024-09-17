pipeline {
  agent any
  stages {
    stage('Build Source') {
      steps {
        bat 'mvn clean'
      }
    }

    stage('Run Chrome') {
      parallel {
        stage('Run Chrome') {
          steps {
            bat 'mvn test -DBROWSER=chrome verify'
          }
        }

        stage('Run Firefox') {
          steps {
            bat 'mvn test -DBROWSER=firefox verify'
          }
        }

      }
    }

  }
}