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
    'lib/Greditor',
    'mod/ivt/BcdtMapMgt'
    ], function (dojo, parser, dijit, tabUtil, accordUtil, dojote) {
        var singleton={
            init:function(){
                this.startup();
            },
            startup:function(){
                dojo.subscribe('onMenuBarangBrowse',dojo.hitch(this,'prepareBarangBrowse'))
            },
            prepareBarangBrowse:function(){
                if(!dojote.cekWidget(this.formBarangBrowse)){
                    this.formBarangBrowse=tabUtil.putinTab('Browse Barang','Load Form Browse Barang');
                    dojote.callXhrJsonPost('./barang/browse/form',dojote.initBrowse(),dojo.hitch(this,function(e){
                        if(dojote.cekWidget(this.formBarangBrowse)){
                            this.formBarangBrowse.set('content',e.html)
                        }
                        this.buildForm();
                    }))
                }else{
                    this.fetchGrid(dojote.initBrowse());
                }
            },
            buildForm:function(){
                var divGreditor = dojo.query('.gdtBarang',this.formBarangBrowse.domNode);
                console.log(divGreditor);
                this.gdtBarang = new lib.Greditor({
                    structure:[
                    {
                        field:'nama', 
                        name:'Nama', 
                        width:'100%'
                    }
                    ],
                    paramItems:[
                    {
                        field:'nama', 
                        name:'Nama', 
                        type:'teks'
                    }],
                    withEditor:false
                },divGreditor[0]);
            //                this.fetchGrid(dojote.initBrowse());
            },
            fetchGrid:function(fetchParam){
                dojote.callXhrJsonPost('./barang/browse/fetch',fetchParam,dojo.hitch(this,function(e){
                    if(e.data && dojote.cekWidget(this.formBarangBrowse)){
                        this.gdtBarang.setJStore(e.data)
                    }
                }))
            }
        }
        singleton.init();
        return singleton;
    })
