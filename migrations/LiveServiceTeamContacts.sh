#!/bin/bash

echo ""
echo "Applying migration LiveServiceTeamContacts"

echo "Adding routes to conf/app.routes"
echo "" >> ../conf/app.routes
echo "GET        /liveServiceTeamContacts                       controllers.LiveServiceTeamContactsController.onPageLoad()" >> ../conf/app.routes

echo "Adding messages to conf.messages"
echo "" >> ../conf/messages.en
echo "liveServiceTeamContacts.title = liveServiceTeamContacts" >> ../conf/messages.en
echo "liveServiceTeamContacts.heading = liveServiceTeamContacts" >> ../conf/messages.en

echo "Migration LiveServiceTeamContacts completed"
