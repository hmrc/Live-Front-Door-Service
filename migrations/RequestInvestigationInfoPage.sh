#!/bin/bash

echo ""
echo "Applying migration RequestInvestigationInfoPage"

echo "Adding routes to conf/app.routes"
echo "" >> ../conf/app.routes
echo "GET        /requestInvestigationInfoPage                       controllers.RequestInvestigationInfoPageController.onPageLoad()" >> ../conf/app.routes

echo "Adding messages to conf.messages"
echo "" >> ../conf/messages.en
echo "requestInvestigationInfoPage.title = requestInvestigationInfoPage" >> ../conf/messages.en
echo "requestInvestigationInfoPage.heading = requestInvestigationInfoPage" >> ../conf/messages.en

echo "Migration RequestInvestigationInfoPage completed"
