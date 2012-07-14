/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

define(['dojo',
    'dojo/parser',
    'dijit/registry',
    'lib/TabUtil',
    'lib/AccordUtil',
    'lib/dojote',
    'dojox/form/Manager',
    'dijit/form/TextBox',
    'dijit/form/Textarea',
    'lib/CustomDatebox',
    'lib/CustomButton',
    'lib/LookupParam',
    'lib/Greditor'
], function (dojo, parser, dijit, tabUtil, accordUtil, dojote) {
    var singleton = {
        init:function () {
            this.startup();
        },
        startup:function () {
            dojo.subscribe('onMenuBarangBrowse', dojo.hitch(this, 'prepareBarangBrowse'))
        },
        prepareBarangBrowse:function () {
            if (!dojote.cekWidget(this.formBarangBrowse)) {
                this.formBarangBrowse = tabUtil.putinFirstTab('Browse Barang', 'Load Form Browse Barang');
                dojote.callXhrJsonPost('./barang/browse/form', dojote.initBrowse(), dojo.hitch(this, function (e) {
                    if (dojote.cekWidget(this.formBarangBrowse)) {
                        this.formBarangBrowse.set('content', e.html)
                    }
                    this.buildForm();
                }))
            } else {
//                this.fetchGrid(dojote.initBrowse());
                tabUtil.selectTab(this.formBarangBrowse);
            }
        },
        buildForm:function () {
            var divGreditor = dojo.query('.gdtBarang', this.formBarangBrowse.domNode);
            console.log(divGreditor);
            this.gdtBarang = new lib.Greditor({
                structure:[
                    {field:'nama', name:'Namas', width:'30%'},
                    {field:'alamat', name:'Alamat', width:'70%'}
                ],
                paramItems:[
                    {
                        field:'nama',
                        name:'Namas',
                        type:'teks'
                    }
                ],
                withEditor:true
            }, divGreditor[0]);
            console.log('after init greditor');
            this.gdtBarang.setJStore([
                {alamat:'Rawamangun', nama:'Nama'}
            ]);
            console.log('after set jstore')
            if (!this.formBarangBrowse.onAddHandler)
                this.formBarangBrowse.onAddHandler = dojo.connect(this.gdtBarang, 'onTambah', dojo.hitch(this, function () {
                    this.fetchGrid(dojote.initBrowse());
                }));
        },
        fetchGrid:function (fetchParam) {
            console.log('this is onfetc')
            console.log(fetchParam);
            dojote.callXhrJsonPost('./barang/browse/fetch', {nama:'Tejo A Kusuma', barang:{nama:"Citato",merk:"Citato Never Flat"}, fentry:{alias:"Tejo", range:true}}, dojo.hitch(this, function (e) {
                if (e.data && dojote.cekWidget(this.formBarangBrowse)) {
                    console.log(e.data);
                    this.gdtBarang.setJStore(e.data);

                }
            }))
        }
    }
    singleton.init();
    return singleton;
})
