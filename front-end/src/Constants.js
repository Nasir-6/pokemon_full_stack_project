export const SERVER_URL = process.env.NODE_ENV == 'production'? "http://pokepals-backend.eu-west-2.elasticbeanstalk.com" : "http://localhost:8080"
// Port 5000 is the aws elastic beanstalk port which we will deploy whole app onto!!