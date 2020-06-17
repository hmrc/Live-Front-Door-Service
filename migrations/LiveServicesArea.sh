#!/bin/bash

echo ""
echo "Applying migration LiveServicesArea"

echo "Adding routes to conf/app.routes"
echo "" >> ../conf/app.routes
echo "GET        /liveServicesArea                       controllers.LiveServicesAreaController.onPageLoad()" >> ../conf/app.routes

echo "Adding messages to conf.messages"
echo "" >> ../conf/messages.en
echo "liveServicesArea.title = liveServicesArea" >> ../conf/messages.en
echo "liveServicesArea.heading = liveServicesArea" >> ../conf/messages.en

echo "Migration LiveServicesArea completed"
