#!/bin/bash

echo ""
echo "Applying migration OccurenceHistory"

echo "Adding routes to conf/app.routes"
echo "" >> ../conf/app.routes
echo "GET        /occurenceHistory                       controllers.OccurenceHistoryController.onPageLoad()" >> ../conf/app.routes

echo "Adding messages to conf.messages"
echo "" >> ../conf/messages.en
echo "occurenceHistory.title = occurenceHistory" >> ../conf/messages.en
echo "occurenceHistory.heading = occurenceHistory" >> ../conf/messages.en

echo "Migration OccurenceHistory completed"
