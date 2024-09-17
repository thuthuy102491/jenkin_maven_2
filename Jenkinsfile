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

    stage('Report') {
      steps {
        testNG(failedFails: 1, failedSkips: 1, failureOnFailedTestConfig: true, reportFilenamePattern: 'ReportMaven', showFailedBuilds: true, thresholdMode: 1)
      }
    }

  }
}