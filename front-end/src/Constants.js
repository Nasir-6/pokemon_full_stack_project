export const SERVER_URL = process.env.NODE_ENV == 'production'? "http://localhost:5000" : "http://localhost:8080"
// Port 5000 is the aws elastic beanstalk port which we will deploy whole app onto!!