#!/bin/bash

echo ""
echo "Applying migration LiveServiceLnding"

echo "Adding routes to conf/app.routes"
echo "" >> ../conf/app.routes
echo "GET        /liveServiceLnding                       controllers.LiveServiceLndingController.onPageLoad()" >> ../conf/app.routes

echo "Adding messages to conf.messages"
echo "" >> ../conf/messages.en
echo "liveServiceLnding.title = liveServiceLnding" >> ../conf/messages.en
echo "liveServiceLnding.heading = liveServiceLnding" >> ../conf/messages.en

echo "Migration LiveServiceLnding completed"
