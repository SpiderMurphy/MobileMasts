# MobileMasts

<b>Data File To be Used:</b>

Dataset source: https://data.gov.uk/dataset/mobile-phone- masts
(The attached CSV contains publicly available data about mobile phone masts in an area of the UK.)
Contains public sector information licensed under the Open Government Licence v3.0.

<b>Dataset description:</b>

This dataset provides information on mobile phone masts located on Leeds City Council

<b>Requirements : </b>

1) Read in the attached file and produce a list sorted by lease amount in ascending order. Display the first 5
results in a table that can then be toggled between ascending/descending value.

2) Allow the user to enter a new entry to the list of mast data. When adding this entry update the frontend to
display this new entry if it meets the lease amount requirements from point

3) Display the total rent for all items in this list.

4) Create a dictionary containing tenant name and a count of masts for each tenant. Display a list of tenants
currently on show and the count of masts they each have.

NOTE. Treat &quot;Everything Everywhere Ltd&quot; and &quot;Hutchinson3G Uk Ltd&amp;Everything Everywhere Ltd&quot; as
separate entities.

5) List the data for rentals with Lease Start Date between 1 June 1999 and 31 Aug 2007.
List these rentals with the date format of: DD/MM/YYYY.

<b>Solutions : </b>

1) OpenCsv 4 was used to read the csv file provided.Couldn't use a proper data's deserialization because of Android SDK doesn't implement Java Beans Introspector, and CsvToBean requires beans to deserialize data into POJO.The class responsibile to that is MastParser (100% Test Covered).

  A list reppresentation was used to display data (according to material guidelines).

2) Not done.

3) Done but not displaying.

4) In the second tab there's a list containing information about the top 5 tenants and the sum of their masts (an Hashmap was used to collect the data).

5) Not done.


<b>UnitTest : </b>

Android components hasn't been tested (Activity, Adapter), however a Presenter has been provided to test recycler view Adapter's behaviors without running an instrumented test.

<b>Screenshots</b>

<p float="left">
  <img src="https://user-images.githubusercontent.com/13555265/36933554-5296ae34-1edb-11e8-8315-84b8c6d6d32c.png" width="400" hspace="40" />
  <img src="https://user-images.githubusercontent.com/13555265/36933555-52b1c2b4-1edb-11e8-987b-efb7a08302f3.png" width="400" />
</p>
