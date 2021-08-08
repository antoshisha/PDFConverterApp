<?xml version="1.0" encoding="UTF-8"?>
<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <fo:layout-master-set>
        <fo:simple-page-master margin-right="2cm" margin-left="2cm" margin-bottom="2cm" margin-top="2cm" page-width="21cm" page-height="29.7cm" master-name="simpleA4">
            <fo:region-body />
        </fo:simple-page-master>
    </fo:layout-master-set>
    <fo:page-sequence master-reference="simpleA4">
        <fo:flow flow-name="xsl-region-body">
            <fo:block space-after="5mm" font-weight="bold" font-size="16pt">Person Group: Employee</fo:block>
            <fo:block font-size="10pt">
                <fo:table border-collapse="separate" width="100%" table-layout="fixed">
                    <fo:table-column column-width="4cm" />
                    <fo:table-column column-width="5cm" />
                    <fo:table-column column-width="5cm" />
                    <fo:table-body>
                        <fo:table-row>
                            <fo:table-cell>
                                <fo:block>Person name: ${person.name}</fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block>Person surname: ${person.surName}</fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block>Person age: ${person.age}</fo:block>
                            </fo:table-cell>
                        </fo:table-row>
                    </fo:table-body>
                </fo:table>
            </fo:block>
        </fo:flow>
    </fo:page-sequence>
</fo:root>